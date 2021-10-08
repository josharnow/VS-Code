package com.codingdojo.omikujiform.models;
public class Form {
  // MEMBER VARIABLES
  private int number;
  private String city;
  private String person;
  private String endeavor;
  private String livingThing;
  private String textBox;

  // CONSTRUCTOR
  public Form(int number, String city, String person, String endeavor, String livingThing, String textBox) {
    super();
    this.number = number;
    this.city = city;
    this.person = person;
    this.endeavor = endeavor;
    this.livingThing = livingThing;
    this.textBox = textBox;
  }

  // GETTERS AND SETTERS
  /**
   * @return the number
   */
  public int getNumber() {
    return number;
  }

  /**
   * @param number the number to set
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the person
   */
  public String getPerson() {
    return person;
  }

  /**
   * @param person the person to set
   */
  public void setPerson(String person) {
    this.person = person;
  }

  /**
   * @return the endeavor
   */
  public String getEndeavor() {
    return endeavor;
  }

  /**
   * @param endeavor the endeavor to set
   */
  public void setEndeavor(String endeavor) {
    this.endeavor = endeavor;
  }

  /**
   * @return the livingThing
   */
  public String getLivingThing() {
    return livingThing;
  }

  /**
   * @param livingThing the livingThing to set
   */
  public void setLivingThing(String livingThing) {
    this.livingThing = livingThing;
  }

  /**
   * @return the textBox
   */
  public String getTextBox() {
    return textBox;
  }

  /**
   * @param textBox the textBox to set
   */
  public void setTextBox(String textBox) {
    this.textBox = textBox;
  }
}
