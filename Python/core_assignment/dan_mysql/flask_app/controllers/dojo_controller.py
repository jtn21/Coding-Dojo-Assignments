from unicodedata import name
from flask_app import app
from flask import render_template, redirect, request
from flask_app.models.dojo_model import Dojo

@app.route("/")
def test():
    return render_template("index.html")

# ======================this route is showing the create dojo page and the list of dojs
@app.route("/dojos")
def show_dojo_form():

# =======================this passes the info that allows the list of dojos to show up
    all_dojos = Dojo.get_all_dojos()

    return render_template('/create_dojo.html', all_dojos = all_dojos)

# this route allows information to be sent to server and then redirects back to the submission form
@app.route("/dojos/submit", methods = ['POST'])
def submit_dojo_form():
    data = {
        'name': request.form[ 'name' ]
    }

    Dojo.create_one_dojo(data)
    return redirect('/all_dojos')

# ===============================display route===============

@app.route('/all_dojos')
def display_all_dojos():

    all_dojos = Dojo.get_all_dojos()

    return render_template('/create_dojo.html', all_dojos = all_dojos)


@app.route('/dojos/<int:id>')
def display_one_dojo(id):
    data = {
        'id' : id
    }

    one_dojo = Dojo.get_dojo_with_ninjas(data)
    return render_template('show_ninja.html', one_dojo = one_dojo)
