package by.training.task08.beans;

import java.util.Objects;

public class Candy {
    private String name;
    private int energy;
    private String type;
    private String production;
    private String dateManufactured;
    private String country;
    private String price = "-";
    private final Value value = new Value();
    private final Ingredients ingredients = new Ingredients();

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", type='" + type + '\'' +
                ", production='" + production + '\'' +
                ", dateManufactured='" + dateManufactured + '\'' +
                ", country='" + country + '\'' +
                ", price='" + price + '\'' +
                ", value=" + value +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return energy == candy.energy && Objects.equals(name, candy.name) && Objects.equals(type, candy.type) && Objects.equals(production, candy.production) && Objects.equals(dateManufactured, candy.dateManufactured) && Objects.equals(country, candy.country) && Objects.equals(price, candy.price) && Objects.equals(value, candy.value) && Objects.equals(ingredients, candy.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, energy, type, production, dateManufactured, country, price, value, ingredients);
    }

    public class Value {
        private double proteins;
        private double fats;
        private double carbohydrates;

        public double getProteins() {
            return proteins;
        }

        public void setProteins(double proteins) {
            this.proteins = proteins;
        }

        public double getFats() {
            return fats;
        }

        public void setFats(double fats) {
            this.fats = fats;
        }

        public double getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(double carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "proteins=" + proteins +
                    ", fats=" + fats +
                    ", carbohydrates=" + carbohydrates +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Value value = (Value) o;
            return Double.compare(value.proteins, proteins) == 0 && Double.compare(value.fats, fats) == 0 && Double.compare(value.carbohydrates, carbohydrates) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(proteins, fats, carbohydrates);
        }
    }

    public class Ingredients{
        private int water;
        private int caramel;
        private int sugar;
        private int fructose;
        private final Chocolate chocolate = new Chocolate();
        private int oil;
        private int milk;
        private int sourCream;
        private int condensedMilk;
        private int eggsProtein;
        private final Nuts nuts = new Nuts();
        private int gelatin;

        @Override
        public String toString() {
            return "Ingredients{" +
                    "water=" + water +
                    ", caramel=" + caramel +
                    ", sugar=" + sugar +
                    ", fructose=" + fructose +
                    ", chocolate=" + chocolate +
                    ", oil=" + oil +
                    ", milk=" + milk +
                    ", sourCream=" + sourCream +
                    ", condensedMilk=" + condensedMilk +
                    ", eggsProtein=" + eggsProtein +
                    ", nuts=" + nuts +
                    ", gelatin=" + gelatin +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ingredients that = (Ingredients) o;
            return water == that.water && caramel == that.caramel && sugar == that.sugar && fructose == that.fructose && oil == that.oil && milk == that.milk && sourCream == that.sourCream && condensedMilk == that.condensedMilk && eggsProtein == that.eggsProtein && gelatin == that.gelatin && Objects.equals(chocolate, that.chocolate) && Objects.equals(nuts, that.nuts);
        }

        @Override
        public int hashCode() {
            return Objects.hash(water, caramel, sugar, fructose, chocolate, oil, milk, sourCream, condensedMilk, eggsProtein, nuts, gelatin);
        }

        public class Chocolate{
            private String typeChocolate = "-";
            private int weight;

            public String getTypeChocolate() {
                return typeChocolate;
            }

            public void setTypeChocolate(String typeChocolate) {
                this.typeChocolate = typeChocolate;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            @Override
            public String toString() {
                return "Chocolate{" +
                        "typeChocolate='" + typeChocolate + '\'' +
                        ", weight=" + weight +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Chocolate chocolate = (Chocolate) o;
                return weight == chocolate.weight && Objects.equals(typeChocolate, chocolate.typeChocolate);
            }

            @Override
            public int hashCode() {
                return Objects.hash(typeChocolate, weight);
            }
        }

        public class Nuts{
            private String typeNuts = "-";
            private int weight;

            public String getTypeNuts() {
                return typeNuts;
            }

            public void setTypeNuts(String typeNuts) {
                this.typeNuts = typeNuts;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            @Override
            public String toString() {
                return "Nuts{" +
                        "typeNuts='" + typeNuts + '\'' +
                        ", weight=" + weight +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Nuts nuts = (Nuts) o;
                return weight == nuts.weight && Objects.equals(typeNuts, nuts.typeNuts);
            }

            @Override
            public int hashCode() {
                return Objects.hash(typeNuts, weight);
            }
        }

        public Chocolate getChocolate() {
            return chocolate;
        }

        public Nuts getNuts() {
            return nuts;
        }

        public int getWater() {
            return water;
        }

        public void setWater(int water) {
            this.water = water;
        }

        public int getCaramel() {
            return caramel;
        }

        public void setCaramel(int caramel) {
            this.caramel = caramel;
        }

        public int getSugar() {
            return sugar;
        }

        public void setSugar(int sugar) {
            this.sugar = sugar;
        }

        public int getFructose() {
            return fructose;
        }

        public void setFructose(int fructose) {
            this.fructose = fructose;
        }

        public int getOil() {
            return oil;
        }

        public void setOil(int oil) {
            this.oil = oil;
        }

        public int getMilk() {
            return milk;
        }

        public void setMilk(int milk) {
            this.milk = milk;
        }

        public int getSourCream() {
            return sourCream;
        }

        public void setSourCream(int sourCream) {
            this.sourCream = sourCream;
        }

        public int getCondensedMilk() {
            return condensedMilk;
        }

        public void setCondensedMilk(int condensedMilk) {
            this.condensedMilk = condensedMilk;
        }

        public int getEggsProtein() {
            return eggsProtein;
        }

        public void setEggsProtein(int eggsProtein) {
            this.eggsProtein = eggsProtein;
        }

        public int getGelatin() {
            return gelatin;
        }

        public void setGelatin(int gelatin) {
            this.gelatin = gelatin;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getDateManufactured() {
        return dateManufactured;
    }

    public void setDateManufactured(String dateManufactured) {
        this.dateManufactured = dateManufactured;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Value getValue() {
        return value;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

}
