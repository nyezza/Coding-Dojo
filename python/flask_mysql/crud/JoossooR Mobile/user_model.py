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
    
    