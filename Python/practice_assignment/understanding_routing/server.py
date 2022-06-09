from ctypes.wintypes import WORD
from flask import Flask
app = Flask( __name__ )

#this is the url to access whatever gets displayed on page
@app.route('/')
def hello_world():
    return "Hello World!"

@app.route('/dojo')
def say_dojo():
    return "Dojo!"

# '/say/__' anything after /say/ gets passed as variable 'name'
@app.route('/say/<name>')
def say(name):
    print(name)
    return "Hi, " + name + "!"

@app.route('/repeat/<num>/<str>')
def repeat(num, str):
    return int(num)*str




if __name__ == "__main__":
    app.run( debug = True )