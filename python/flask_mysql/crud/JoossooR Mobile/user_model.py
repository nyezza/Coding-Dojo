from mysqlconnection import connectToMySQL
class User:
    def __init__(self,data):
        self.id=data['id']
        self.code_client=data['code_client']
        self.societe=data['societe']
        self.site=data['site']
        self.numero=data['numero']
        self.porteur=data['porteur']
        self.forfait=data['forfait']
        self.montant_ssr=data['montant_ssr']
        self.montant_ar=data['montant_ar']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
    
    @classmethod    
    def get_all(cls):
        query =""" SELECT * FROM users;"""
        results=connectToMySQL("joossoor_mobile").query_db(query)
        porters=[]
        for row in results:
            porters.append(cls(row))
        return porters

    @classmethod
    def create(cls,data):
        query = """
            insert into users (code_client,societe,site,numero,porteur,forfait,montant_ssr,montant_ar) 
            values (%(code_client)s,%(societe)s,%(site)s,%(numero)s,%(porteur)s,%(forfait)s,%(montant_ssr)s,%(montant_ar)s)
        """
        result=connectToMySQL("joossoor_mobile").query_db(query,data)
        return result
    
    @classmethod
    def get_one(cls,data):
        query=""" 
            SELECT * FROM users WHERE id = %(id)s; 
        """
        results= connectToMySQL("joossoor_mobile").query_db(query,data)
        print ("le resultat est :",results,"*"*20)
        return cls(results[0])
    
    @classmethod
    def update(cls,data):
        query="""
            UPDATE users SET 
                code_client=%(code_client)s,
                societe=%(societe)s,
                site=%(site)s,
                numero=%(numero)s,
                porteur=%(porteur)s,
                forfait=%(forfait)s,
                montant_ssr=%(montant_ssr)s,
                montant_ar=%(montant_ar)s 
            WHERE id=%(id)s;
        """
        return connectToMySQL("joossoor_mobile").query_db(query,data)
    
    @classmethod
    def delete(cls,data):
        query= """
            DELETE FROM users WHERE id = %(id)s;
        """
        return connectToMySQL("joossoor_mobile").query_db(query,data)