from flask_app.models.recipe_models import Recipe
from flask_app import app
import re
from flask import flash,render_template,redirect,session,request

@app.route('/recipes/new')
def new_recipe():
    if 'user_id' not in session:
        return redirect('/')
    return render_template("create-recipes.html")

@app.route('/recipes/create',methods=['post'])
def create_recipe():
    if not Recipe.validation(request.form):
        return redirect('/recipes/new')
    data={
        **request.form,
        'user_id':session['user_id']
    }
    Recipe.create_recipe(data)
    return redirect('/dashboard')

@app.route('/recipes/edit/<int:recipe_id>')
def edit_recipe(recipe_id):
    if 'user_id' not in session:
        return redirect('/')
    recipe=Recipe.get_by_id({'id':recipe_id})
    return render_template("edit_recipes.html",recipe=recipe)

@app.route('/recipes/update',methods=['post'])
def update_recipe():
    if 'user_id' not in session:
        return redirect('/')
    if not Recipe.validation(request.form):
        return redirect('/recipes/edit'+ request.form['id'])
    Recipe.update(request.form)
    return redirect('/dashboard')

@app.route('/recipes/<int:recipe_id>')
def view(recipe_id):
    if 'user_id' not in session:
        return redirect('/')
    recipe=Recipe.get_by_id({'id':recipe_id})
    return render_template("view_one_recipe.html",recipe=recipe)

@app.route('/remove/<int:recipe_id>')
def remove(recipe_id):
    if 'user_id' not in session:
        return redirect('/')
    Recipe.remove({'id':recipe_id})
    return redirect('/dashboard')
