from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user_model import User
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt( app )


@app.route('/register')
def show_register_form():

    return render_template('register.html')

@app.route('/dashboard')
def display_dashboard():
    return render_template('dashboard.html')

@app.route('/register/submit', methods=['POST'] )
def submit_register_form():
    if User.validate_registration( request.form) == True:
        data = {
            "email" : request.form[ 'email' ]
        }
        result = User.get_one( data )

        if result == None:
            if not request.form[ 'password' ] == request.form['confirm_password']:
                flash("Passwords must match", "error_password")
                return redirect('/register')

            data = {
                'first_name': request.form[ 'first_name' ],
                'last_name': request.form[ 'last_name' ],
                'email': request.form['email'],
                'password': bcrypt.generate_password_hash(request.form['password'])

            }
            user_id = User.register_one_user( data )
            print(user_id)

            session[ 'email' ] = request.form[ 'email' ]
            session[ 'first_name' ] = request.form[ 'first_name' ]
            session[ 'last_name' ] = request.form[ 'last_name' ]
            session[ 'id' ] = user_id
            return redirect ("/dashboard")

        else:
            flash( "That email already exists, please use a different one.", "error_email" )
            return redirect('/register')

    else:
        redirect ("/register")
    
    

    id = User.register_one_user(data)
    session['id'] = id

    User.register_one_user(data)
    return redirect('/dashboard')

@app.route('/login')
def show_login_form():
    return render_template('register.html')


@app.route('/login/submit', methods=['POST'] )
def submit_login_form():
    data = {
        'email' : request.form[ 'email' ],
        }
    result = User.get_one(data)

    if result == None:
        flash( "Wrong credentials.", "error_login")
        return redirect("/register")
    else:
        if not bcrypt.check_password_hash( result.password, request.form[ 'password' ] ):
            flash ( "Wrong credentials.", "error_login")
            return redirect('/register')
        else:
            session[ 'email' ] = result.email
            session[ 'first_name' ] = result.first_name
            session[ 'last_name' ] = result.last_name
            session[ 'id' ] = result.id
            return redirect('/dashboard')

@app.route( "/logout" )
def logout():
    session.clear()
    return redirect("/register")