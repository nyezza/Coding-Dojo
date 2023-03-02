from mysqlconnection import connectToMySQL

class Users:
    def __init__(self,data):
        self.id= data['id']
        self.First_Name= data['First_Name']
        self.Last_Name= data['Last_Name']
        self.Email= data['Email']
        
    @classmethod
    def read_all(cls):
        query="""
            SELECT * FROM users
        """
        result=connectToMySQL("user_db").query_db(query)
        users_list=[]
        for row in result:
            users_list.append(cls(row))
        return users_list
        