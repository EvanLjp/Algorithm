package com.evan.design.pattern.creational.builder;


/**
 * @author :evan
 * @date :2018-08-28 13:41
 **/
public class Computer {
    private String cpu;
    private String mainBoard;
    private String hardDisk;
    private String displayCard;
    private String power;
    private String memory;

    public Computer(Builder computerBuilder) {
        this.cpu = computerBuilder.cpu;
        this.mainBoard = computerBuilder.mainBoard;
        this.hardDisk = computerBuilder.hardDisk;
        this.displayCard = computerBuilder.displayCard;
        this.power = computerBuilder.power;
        this.memory = computerBuilder.memory;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", displayCard='" + displayCard + '\'' +
                ", power='" + power + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }

    public static class Builder {
        private String cpu;
        private String mainBoard;
        private String hardDisk;
        private String displayCard;
        private String power;
        private String memory;

        public Builder builderCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder builderMainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        public Builder builderHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public Builder builderDisplayCard(String displayCard) {
            this.displayCard = displayCard;
            return this;
        }


        public Builder builderPower(String power) {
            this.power = power;
            return this;
        }

        public Builder builderMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }


}

