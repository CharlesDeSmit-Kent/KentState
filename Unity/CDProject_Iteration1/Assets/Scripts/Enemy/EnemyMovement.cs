using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyMovement : MonoBehaviour
{
    Transform player;
    bool reverse;
    PlayerHealth playerHealth;
    EnemyHealth enemyHealth;
    UnityEngine.AI.NavMeshAgent nav;

    GameObject powerUpController;
    PowerUpActive PowerUp;
    void Awake()
    {
        player = GameObject.FindGameObjectWithTag("Player").transform;
        playerHealth = player.GetComponent<PlayerHealth>();
        enemyHealth = GetComponent<EnemyHealth>();
        nav = GetComponent<UnityEngine.AI.NavMeshAgent>();
        reverse = false;

        powerUpController = GameObject.FindGameObjectWithTag("GameController");
        PowerUp = powerUpController.GetComponent<PowerUpActive>();
    }


    void Update()
    {
        float distance = Vector3.Distance(player.position, transform.position);
        if (enemyHealth.currentHealth > 0 && playerHealth.currentHealth > 0 && distance < 5)                  
            nav.SetDestination(player.position);       
        else
            nav.enabled = false;
    }
}
