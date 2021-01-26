using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HealthPickUp : MonoBehaviour {
    PlayerHealth playerHealth;
    GameObject player;

    // Use this for initialization
    void Awake() {
        player = GameObject.FindGameObjectWithTag("Player");
        playerHealth = player.GetComponent<PlayerHealth>();
    }

    // Update is called once per frame
    void Update () {
		
	}

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject == player)
        {
            playerHealth.HealDamage();
            Destroy(gameObject);
        }
    }
}
