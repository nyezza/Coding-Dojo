from flask import Blueprint,jsonify,request,redirect
from flask_app import app 
from flask_app.models.users_model import User
from flask_bcrypt import Bcrypt 

bcrypt = Bcrypt(app)
user_api = Blueprint('user_api',__name__)

@user_api.route('/')
def main():
    return "hello there"

@user_api.route('/api/users')
def all_Users():
    user=User.all_users()
    print(user)
    # users_list=[{'id':user.id,"first_name":user.first_name,"last_name":user.last_name,"password":user.password}]
    return jsonify(user)

@user_api.route('/api/users/new', methods=['POST'])
def createOne():
    print(request.form)
    User.new_user(request.form)
    return (redirect('/'))