from classes.ninja import Ninja
from classes.pirate import Pirate
class Game:
    def __init__(self):
        pass
    def show_stats( self ):
        print(f"Name: {self.name}\nStrength: {self.strength}\nSpeed: {self.speed}\nHealth: {self.health}\n")    

michelangelo = Ninja("Michelanglo")

jack_sparrow = Pirate("Jack Sparrow")

# michelangelo.attack(jack_sparrow).show_stats()
# jack_sparrow.attack(michelangelo).show_stats()

# michelangelo.attack(jack_sparrow)
# Game.show_stats(jack_sparrow)

raff=Ninja("Raff")
gibs=Pirate("Gibs")

while raff.health >0 or gibs.health>0:
    raff.attack(gibs)
    Game.show_stats(raff)
    Game.show_stats(gibs)
    gibs.attack(raff)
    Game.show_stats(raff)
    Game.show_stats(gibs)
if gibs.health> raff.health:
    print(f"{gibs.name} is the winner")
else:
    print(f"{raff.name} is the winner")
