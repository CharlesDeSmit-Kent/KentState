using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PowerUpPickUp : MonoBehaviour {
    GameObject powerUpController;
    PowerUpActive turnOnPowerUp;
    GameObject player;
    // Use this for initialization
    void Awake () {
        powerUpController= GameObject.FindGameObjectWithTag("GameController");
        turnOnPowerUp = powerUpController.GetComponent<PowerUpActive>();
        player = GameObject.FindGameObjectWithTag("Player");
    }

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject == player)
        {
            turnOnPowerUp.powerUpActive = true;
            Destroy(gameObject);
        }
    }
}
