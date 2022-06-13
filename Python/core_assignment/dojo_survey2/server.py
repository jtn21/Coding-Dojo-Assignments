from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "secret"


@app.route("/")
def home_page():
    return render_template("index.html")


@app.route( "/users", methods = ['POST'] )
def result():
    print(request.form)
    session["name"] = request.form['name']
    session["location"] = request.form[ "location" ]
    session["language"] = request.form[ "language" ]
    session["comment"] = request.form[ "comment"]
    return redirect ("/show")

@app.route("/show")
def show_user():
    return render_template("show.html")

if __name__ == "__main__":
    app.run( debug = True )