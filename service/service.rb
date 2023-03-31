require 'sinatra'
require 'json'
require 'securerandom'

HOST = 'https://a193-195-22-227-78.ngrok.io'

get '/' do
  @state = SecureRandom.hex
  @app_link = "#{HOST}/ob-app?state=#{@state}&client_id=123465789"
  @redirect_app_link = "#{HOST}/redirect-ob-app"
  erb :index
end

get '/ob-app' do
  @client_id = params[:client_id]
  @state = params[:state]
  erb :ob_app
end

get '/redirect-ob-app' do
  redirect '/ob-app'
end
