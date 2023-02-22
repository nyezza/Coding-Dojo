from flask import Flask, render_template
app=Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route ('/<int:row>')
def row_simple(row):
    return render_template('index.html',y=row//2)



if __name__=='__main__':
    app.run(debug=True)