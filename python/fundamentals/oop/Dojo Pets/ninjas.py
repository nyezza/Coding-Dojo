from pets import Pet
class Ninja :
    def __init__ (self,first_name,last_name,pet,treats,pet_food):
        self.first_name=first_name
        self.last_name=last_name
        self.pet=pet
        self.treats=treats
        self.pet_food=pet_food
        health=Pet.health
        energy=Pet.energy
    def walk(self):
        Pet.play()
    def feed(self):
        Pet.eat()
    def bath(self):
        Pet.noise()

arbouch=Pet("Arbouch","dog","play")        
tarzan=Ninja("Tarzan","kalb",arbouch,"nothing","croquettes")
print(tarzan.first_name)
tarzan.walk()
tarzan.feed()
tarzan.bath()    
