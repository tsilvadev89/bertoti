import os
import telebot
import requests
from bs4 import BeautifulSoup

# Token do seu bot do Telegram (use variáveis de ambiente)
TOKEN = os.getenv('TELEGRAM_BOT_TOKEN')

bot = telebot.TeleBot(TOKEN)

@bot.message_handler(func=lambda message: True)
def reply_inflacao(message):
    try:
        # Validar entrada do usuário
        if not message.text.isdigit():
            bot.reply_to(message, "Por favor, insira um ano válido.")
            return

        ano_informado = int(message.text)

        # Solicitação HTTP
        url = "https://www.dadosmundiais.com/america/brasil/inflacao.php"
        response = requests.get(url)

        if response.status_code == 200:
            soup = BeautifulSoup(response.content, 'html.parser')
            table = soup.find('table')

            if not table:
                bot.reply_to(message, "Não foi possível encontrar os dados no site.")
                return

            rows = table.find_all('tr')
            inflacao_ano = None

            for row in rows:
                cols = row.find_all('td')
                if len(cols) >= 2:
                    try:
                        ano = int(cols[0].text.strip())
                        inflacao = float(cols[1].text.strip().replace('%', '').replace(',', '.'))
                        if ano == ano_informado:
                            inflacao_ano = inflacao
                            break
                    except ValueError:
                        continue

            if inflacao_ano is not None:
                resposta = f"A inflação no Brasil em {ano_informado} foi de {inflacao_ano}%."
            else:
                resposta = "Ano não encontrado nos dados disponíveis."
            bot.reply_to(message, resposta)
        else:
            bot.reply_to(message, "Erro ao acessar o site. Tente novamente mais tarde.")
    except Exception as e:
        bot.reply_to(message, f"Ocorreu um erro: {str(e)}")

if __name__ == "__main__":
    bot.infinity_polling()
