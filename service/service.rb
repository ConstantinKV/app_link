require 'sinatra'
require 'json'
require 'securerandom'

get '/' do
  @state = SecureRandom.hex
  @app_link = "https://a193-195-22-227-78.ngrok.io/ob-app?state=#{@state}&client_id=123465789"
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
