from mysqlconnection import connectToMySQL

class Users:
    def __init__(self,data):
        self.id= data['id']
        self.first_name= data['first_name']
        self.last_name= data['last_name']
        self.email= data['email']
        
    @classmethod
    def read_all(cls):
        query="""
            SELECT * FROM users;
        """
        result=connectToMySQL("users_shema").query_db(query)
        users_list=[]
        for row in result:
            users_list.append(cls(row))
        return users_list
    
    @classmethod
    def create(cls,data):
        query= """
            insert into users(first_name,last_name,email) values (%(first_name)s,%(last_name)s,%(email)s);
        """
        results = connectToMySQL("users_shema").query_db(query,data)
        return results
        