from mysqlconnection import connectToMySQL
class Books:
    def __init__(self,data):
        self.id= data['id']
        self.title= data['title']
        self.isbn= data['isbn']
        self.author= data['author']
        self.publisher= data['publisher']
        self.publish_year= data['publish_year']
        self.image_small= data['image_small']
        self.image_medium= data['image_medium']
        self.image_large= data['image_large']
        self.created_at= data['created_at']
        self.updated_at= data['updated_at']
        
    @classmethod
    def get_all(cls):
        query= """
            select * from books;
        """
        results= connectToMySQL("books_store").query_db(query)
        books=[]
        for row in results:
            books.append(cls(row))
        return books