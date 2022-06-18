from flask_app import app
from flask import render_template, redirect, request
from flask_app.models.user_model import User


@app.route ("/users/new")
def add_user():
    return render_template("index.html")


@app.route("/users")
def show_users():
    user = User.get_all() 
    return render_template('display.html', user = user )


@app.route("/users/create", methods = ['POST'])
def create_user():
    data = {
        "first_name" : request.form["first_name"],
        "last_name" : request.form["last_name"],
        "email" : request.form["email"] 
    }

    User.create( data )
    print( request.form )
    return redirect ("/users")

@app.route('/users/<int:user_id>')
def display_one_user(user_id):
    data = {
        'user_id' : user_id
    }

    one_user = User.get_one_user(data)
    return render_template('show_user.html', one_user = one_user)

# ===================================EDIT

@app.route( "/users/edit/<int:user_id>")
def edit_user_form(user_id):

    data = {
        'user_id' : user_id
    }

    one_user = User.get_one_user(data)

    return render_template('edit_user.html', one_user = one_user)


@app.route( "/users/edit/<int:user_id>", methods=[ 'POST' ] )
def edit_one_user(user_id):
    data = {
        'first_name' : request.form[ 'first_name' ],
        'last_name' : request.form[ 'last_name' ],
        'email' : request.form[ 'email' ],
        'user_id' : user_id
    }
    User.edit_one_user(data)
    return redirect('/users')

@app.route('/users/delete/<int:user_id>')
def delete_one_user(user_id):

    data = {
        'user_id' : user_id
    }

    User.delete_one_user(data)

    return redirect('/users')