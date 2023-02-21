#import ninjas
class Pet:
    energy=0
    health=0
    def __init__(self,name,type,tricks):
        self.name=name
        self.type=type
        self.tricks=tricks
        # self.health=health
        # self.energy=energy
    @classmethod
    def sleep(cls):
        cls.energy += 25
        print(f"energy:{cls.energy} ")
    @classmethod
    def eat(cls):
        cls.energy += 5
        cls.health += 10
        print(f"energy:{cls.energy}  and health:{cls.health}")
    @classmethod
    def play(cls):
        cls.health +=5
        print(f"health:{cls.health}")
    def noise():
        print("rrrrrrrrrrrrrrrrr")
class arbi (Pet):
    def __init__(self,name,type,color):
        super().__init__(name,type)
        self.color=color
    
    