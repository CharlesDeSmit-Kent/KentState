using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerHealth : MonoBehaviour {

    public int startingHealth = 100;
    public int currentHealth;
    public Slider healthSlider;

    PlayerMove playerMove;
    bool isDead;
    bool damaged;

    // Use this for initialization
    void Awake () {
        currentHealth = startingHealth;
        playerMove = GetComponent<PlayerMove>();

    }

    // Update is called once per frame
    void Update () {
        damaged = false;
        healthSlider.value = currentHealth;
    }
    public void TakeDamage(int amount)
    {
        damaged = true;
        currentHealth -= amount;
        if (currentHealth <= 0 && !isDead)    
            Death();        
    }
    void Death()
    {
        isDead = true;
        playerMove.enabled = false;
    }
}
