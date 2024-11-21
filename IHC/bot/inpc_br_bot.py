# pip install pytelegrambotapi pandas
# pip install beautifulsoup4

import os
import telebot
import requests
from bs4 import BeautifulSoup
from telebot.types import InlineKeyboardMarkup, InlineKeyboardButton
from datetime import datetime

bot = telebot.TeleBot('salvonodriveIHC')

ANO_MIN = 1981
ANO_MAX = datetime.now().year - 1


def buscar_dados_inflacao():
    """Busca os dados de inflação no site e retorna um dicionário com ano: inflação."""
    url = "https://www.dadosmundiais.com/america/brasil/inflacao.php"
    response = requests.get(url)
    if response.status_code == 200:
        soup = BeautifulSoup(response.content, 'html.parser')
        table = soup.find('table')
        if not table:
            return None

        rows = table.find_all('tr')
        inflacao_dict = {}

        for row in rows:
            cols = row.find_all('td')
            if len(cols) >= 2:
                try:
                    ano = int(cols[0].text.strip())
                    inflacao = float(cols[1].text.strip().replace('%', '').replace(',', '.'))
                    inflacao_dict[ano] = inflacao
                except ValueError:
                    continue
        return inflacao_dict
    return None


def gerar_menu_principal():
    """Cria o menu interativo."""
    menu = InlineKeyboardMarkup()
    menu.row_width = 1
    menu.add(
        InlineKeyboardButton("📊 Consultar inflação por ano", callback_data="consultar_inflacao"),
        InlineKeyboardButton("📈 Calcular valorização", callback_data="calcular_valorizacao"),
        InlineKeyboardButton("💰 Calcular desvalorização", callback_data="calcular_desvalorizacao"),
        InlineKeyboardButton("🔢 Inflação acumulada", callback_data="calcular_acumulada")
    )
    return menu


def perguntar_outra_consulta(message):
    """Pergunta ao usuário se deseja realizar outra consulta."""
    menu_sim_nao = InlineKeyboardMarkup()
    menu_sim_nao.row_width = 2
    menu_sim_nao.add(
        InlineKeyboardButton("Sim", callback_data="outra_consulta_sim"),
        InlineKeyboardButton("Não", callback_data="outra_consulta_nao")
    )
    bot.send_message(message.chat.id, "Deseja realizar outra consulta?", reply_markup=menu_sim_nao)


@bot.callback_query_handler(func=lambda call: call.data in ["outra_consulta_sim", "outra_consulta_nao"])
def tratar_outra_consulta(call):
    """Trata a resposta sobre realizar outra consulta."""
    if call.data == "outra_consulta_sim":
        bot.send_message(call.message.chat.id, "Ótimo! Escolha uma das opções abaixo:", reply_markup=gerar_menu_principal())
    elif call.data == "outra_consulta_nao":
        bot.send_message(call.message.chat.id, "Obrigado por utilizar o bot! Qualquer dúvida, é só me chamar novamente. 😊")


@bot.message_handler(func=lambda message: True)
def inicializar_menu(message):
    """Mostra o menu inicial quando o bot recebe qualquer mensagem."""
    bot.reply_to(message, "Olá! Escolha uma das opções abaixo:", reply_markup=gerar_menu_principal())


@bot.callback_query_handler(func=lambda call: True)
def tratar_opcoes(call):
    """Trata as interações do menu."""
    if call.data == "consultar_inflacao":
        bot.send_message(call.message.chat.id, f"Digite o ano que você quer consultar (entre {ANO_MIN} e {ANO_MAX}).")
        bot.register_next_step_handler(call.message, consultar_inflacao)
    elif call.data == "calcular_valorizacao":
        bot.send_message(call.message.chat.id, "Digite o ano inicial, ano final e o valor separados por vírgulas.\nExemplo: 2000,2023,100")
        bot.register_next_step_handler(call.message, calcular_valorizacao)
    elif call.data == "calcular_desvalorizacao":
        bot.send_message(call.message.chat.id, "Digite o ano inicial, ano final e o valor separados por vírgulas.\nExemplo: 2010,2020,10000")
        bot.register_next_step_handler(call.message, calcular_desvalorizacao)
    elif call.data == "calcular_acumulada":
        bot.send_message(call.message.chat.id, "Digite o ano inicial e final separados por vírgula.\nExemplo: 2000,2023")
        bot.register_next_step_handler(call.message, calcular_acumulada)


def consultar_inflacao(message):
    try:
        ano = int(message.text)
        if ANO_MIN <= ano <= ANO_MAX:
            inflacao_dados = buscar_dados_inflacao()
            if inflacao_dados and ano in inflacao_dados:
                bot.reply_to(message, f"A inflação no Brasil em {ano} foi de {inflacao_dados[ano]:.2f}%.")
            else:
                bot.reply_to(message, f"Dados de inflação para {ano} não encontrados.")
        else:
            bot.reply_to(message, f"O ano deve estar entre {ANO_MIN} e {ANO_MAX}.")
            bot.send_message(message.chat.id, f"Digite novamente um ano válido (entre {ANO_MIN} e {ANO_MAX}).")
            bot.register_next_step_handler(message, consultar_inflacao)
            return  # Impede a execução da próxima parte
    except ValueError:
        bot.reply_to(message, "Por favor, insira um ano válido.")
        bot.send_message(message.chat.id, f"Digite novamente um ano válido (entre {ANO_MIN} e {ANO_MAX}).")
        bot.register_next_step_handler(message, consultar_inflacao)
        return  # Impede a execução da próxima parte

    perguntar_outra_consulta(message)


def calcular_valorizacao(message):
    try:
        dados = message.text.split(',')
        if len(dados) == 3:
            ano_inicial, ano_final, valor_inicial = map(float, dados)
            if ANO_MIN <= ano_inicial <= ano_final <= ANO_MAX:
                inflacao_dados = buscar_dados_inflacao()
                valor_atual = valor_inicial
                for ano in range(int(ano_inicial), int(ano_final) + 1):
                    inflacao = inflacao_dados.get(ano, 0)
                    valor_atual *= (1 + inflacao / 100)
                bot.reply_to(message, f"R${valor_inicial:.2f} em {int(ano_inicial)} valeria R${valor_atual:.2f} em {int(ano_final)}.")
            else:
                bot.reply_to(message, f"Os anos devem estar entre {ANO_MIN} e {ANO_MAX}, e o inicial menor ou igual ao final.")
                bot.send_message(message.chat.id, "Tente novamente: digite ano_inicial, ano_final e valor.")
                bot.register_next_step_handler(message, calcular_valorizacao)
                return  # Impede a execução da próxima parte
        else:
            bot.reply_to(message, "Entrada inválida. Use o formato: ano_inicial,ano_final,valor")
            bot.register_next_step_handler(message, calcular_valorizacao)
            return  # Impede a execução da próxima parte
    except ValueError:
        bot.reply_to(message, "Entrada inválida. Por favor, use números.")
        bot.send_message(message.chat.id, "Digite novamente no formato correto: ano_inicial,ano_final,valor")
        bot.register_next_step_handler(message, calcular_valorizacao)
        return  # Impede a execução da próxima parte

    perguntar_outra_consulta(message)


def calcular_desvalorizacao(message):
    try:
        dados = message.text.split(',')
        if len(dados) == 3:
            ano_inicial, ano_final, valor_inicial = map(float, dados)
            if ANO_MIN <= ano_inicial <= ano_final <= ANO_MAX:
                inflacao_dados = buscar_dados_inflacao()
                valor_final = valor_inicial
                for ano in range(int(ano_inicial), int(ano_final) + 1):
                    inflacao = inflacao_dados.get(ano, 0)
                    valor_final /= (1 + inflacao / 100)
                bot.reply_to(message, f"R${valor_inicial:.2f} em {int(ano_inicial)} valeria R${valor_final:.2f} em {int(ano_final)}.")
            else:
                bot.reply_to(message, f"Os anos devem estar entre {ANO_MIN} e {ANO_MAX}, e o inicial menor ou igual ao final.")
                bot.send_message(message.chat.id, "Tente novamente: digite ano_inicial, ano_final e valor.")
                bot.register_next_step_handler(message, calcular_desvalorizacao)
                return  # Impede a execução da próxima parte
        else:
            bot.reply_to(message, "Entrada inválida. Use o formato: ano_inicial,ano_final,valor")
            bot.register_next_step_handler(message, calcular_desvalorizacao)
            return  # Impede a execução da próxima parte
    except ValueError:
        bot.reply_to(message, "Entrada inválida. Por favor, use números.")
        bot.send_message(message.chat.id, "Digite novamente no formato correto: ano_inicial,ano_final,valor")
        bot.register_next_step_handler(message, calcular_desvalorizacao)
        return  # Impede a execução da próxima parte

    perguntar_outra_consulta(message)


def calcular_acumulada(message):
    try:
        dados = message.text.split(',')
        if len(dados) == 2:
            ano_inicial, ano_final = map(int, dados)
            if ANO_MIN <= ano_inicial <= ano_final <= ANO_MAX:
                inflacao_dados = buscar_dados_inflacao()
                inflacao_acumulada = 1
                for ano in range(ano_inicial, ano_final + 1):
                    inflacao_acumulada *= (1 + inflacao_dados.get(ano, 0) / 100)
                inflacao_acumulada = (inflacao_acumulada - 1) * 100
                bot.reply_to(message, f"A inflação acumulada de {ano_inicial} a {ano_final} foi de {inflacao_acumulada:.2f}%.")
            else:
                bot.reply_to(message, f"Os anos devem estar entre {ANO_MIN} e {ANO_MAX}, e o inicial menor ou igual ao final.")
                bot.send_message(message.chat.id, "Tente novamente: digite ano_inicial, ano_final.")
                bot.register_next_step_handler(message, calcular_acumulada)
                return  # Impede a execução da próxima parte
        else:
            bot.reply_to(message, "Entrada inválida. Use o formato: ano_inicial,ano_final")
            bot.register_next_step_handler(message, calcular_acumulada)
            return  # Impede a execução da próxima parte
    except ValueError:
        bot.reply_to(message, "Entrada inválida. Por favor, use números.")
        bot.send_message(message.chat.id, "Digite novamente no formato correto: ano_inicial,ano_final")
        bot.register_next_step_handler(message, calcular_acumulada)
        return  # Impede a execução da próxima parte

    perguntar_outra_consulta(message)


if __name__ == "__main__":
    bot.infinity_polling()
