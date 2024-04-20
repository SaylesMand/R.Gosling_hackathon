package ru.samsung.itacademy.mdev.fypet;

public class Form {
    private final String nameDog;
    private final String ageDog;

    private final String breedDog;
    private final int photoDog;




    public Form(String nameDog, String ageDog, String breedDog, int photoDog) {
        this.nameDog = nameDog;
        this.ageDog = ageDog;
        this.breedDog = breedDog;
        this.photoDog = photoDog;
    }



    public String getNameDog() {
        return nameDog;
    }

    public String getAgeDog() {
        return ageDog;
    }

    public String getBreedDog() {
        return breedDog;
    }

    public int getPhotoDog() {
        return photoDog;
    }
}