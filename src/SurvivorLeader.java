public class SurvivorLeader {
    private String transmission = "q2xf1t8r5w3t tm9c5i8l900d5n7heto 3g5t6hgw44y5e7bhty605rh8t5 85ml95ak2k5r7qw5ksp295e5t7p45 o5i3n 6z5n205 9soe5o8hhg5lygtt5dq7th 5 gf34s9o 35j7j5o45k99hg5kyqqcjg5mkpl20z5o629sle5k20sk5k9c5 gh73h qxp25vi8t5i3f2v1q 9x7z6t5l8r9j3o4v5l3l1w 9y5a4d6f7x2c9l5g h8s45ek6";
    Shelter[] shelters = new Shelter[40];

    public static void main(String[] args) {
        SurvivorLeader joe = new SurvivorLeader();

    }

    public SurvivorLeader(){
        System.out.println("Goodbye World! Good luck surviving the apocalypse!");

        for(int i=0; i<shelters.length; i++){
            int randDefense = (int)(Math.random()*100)+1;
            int randSupplies = (int)(Math.random()*1000);

            shelters[i] = new Shelter(randDefense,randSupplies);
        }

        displayShelters();
        checkSupplies();
        System.out.println(decipher(transmission));
        newDefense();
        displayShelters();
    }

    public void displayShelters(){
        for(int i=0; i<shelters.length; i++){
            shelters[i].printInfo();
        }
    }

    public boolean checkSupplies(){
        for(int x=0; x<shelters.length; x++){
            for(int y=0; y<shelters.length; y++){
                if(shelters[x].getNumberOfSupplies()==shelters[y].getNumberOfSupplies()&&shelters[x]!=shelters[y]){
                    System.out.println("\nShelter "+x+" supplies:"+shelters[x].getNumberOfSupplies());
                    System.out.println("Shelter "+y+" supplies:"+shelters[y].getNumberOfSupplies());
                    return true;
                }
            }
        }
        return false;
    }

    public String decipher(String transmission){
        String decodedTransmission="\nThere is a supply cache located at: ";
        int counter=0;
        while(counter<transmission.length()){
            char decodedLetter = transmission.charAt(counter);
            if(decodedLetter=='5'){
                decodedTransmission = decodedTransmission + transmission.charAt(counter+1);
            }

            counter+=1;
        }
        return decodedTransmission;
    }

    public void newDefense(){
        for(int x=0; x<shelters.length; x++){
            for(int y=0; y<shelters.length; y++){
                if(shelters[x].getDefenseLevel()==shelters[y].getDefenseLevel()&&shelters[x]!=shelters[y]){
                    int counter =0;
                    while(shelters[y].getDefenseLevel()==shelters[counter].getDefenseLevel()){
                        shelters[y].setDefenseLevel(counter);
                        counter+=1;
                    }

                }
            }
        }
    }
}

