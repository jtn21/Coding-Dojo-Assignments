from flask_app import app
from flask import render_template, redirect, request
from flask_app.controllers.dojo_controller import display_all_dojos
from flask_app.models.ninja_model import Ninja
from flask_app.models.dojo_model import Dojo

@app.route("/ninjas")
def show_ninja_form():
    all_dojos = Dojo.get_all_dojos()
    return render_template("create_ninja.html", all_dojos = all_dojos)


@app.route("/ninjas/submit", methods = ['POST'])
def submit_ninja_form():
    data = {
        "dojo_id": request.form[ 'dojo_id' ],
        "first_name": request.form[ 'first_name' ],
        "last_name": request.form[ 'last_name' ]
    }
    Ninja.create_one_ninja(data)
    return redirect("/dojos")

@app.route('/ninja/<int:id>')
def display_all_ninjas():

    all_ninjas = Ninja.get_all_ninjas()
    all_dojos = Dojo.get_all_dojos()

    return render_template("show_ninja.html", all_ninjas = all_ninjas, all_dojos = all_dojos)