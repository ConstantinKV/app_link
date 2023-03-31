# Proof of concept of App Link redirection flow for Android app

## How to run

1. Go to service: `cd service`
2. Setup dependencies: `bundle install`
3. Start ngrok on 4567 port: `ngrok http 4567`
4. Setup host in `sinatra.rb` and in `AndroidManifest.xml`
5. Setup `/service/public/.well-known/assetlinks.json`
6. Run project: `ruby service.rb`
7. Build Android app
