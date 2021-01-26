using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ZombieAttack : MonoBehaviour
{
    public float timeBetweenAttacks = 0.5f;
    public static int attackDamage;


    GameObject player;
    PlayerHealth playerHealth;
    //EnemyHealth enemyHealth;
    bool playerInRange;
    float timer;
    public static bool Easy = false;
    public static bool Medium = false;
    public static bool Hard = false;



    void Awake()
    {
        player = GameObject.FindGameObjectWithTag("Player");
        playerHealth = player.GetComponent<PlayerHealth>();

        Easy = false;
        Medium = false;
        Hard = false;
        //enemyHealth = GetComponent<EnemyHealth>();
    }


    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject == player)
        {
            playerInRange = true;
        }
    }


    void OnTriggerExit(Collider other)
    {
        if (other.gameObject == player)
        {
            playerInRange = false;
        }
    }


    void Update()
    {
        timer += Time.deltaTime;

        if (timer >= timeBetweenAttacks && playerInRange/* && enemyHealth.currentHealth > 0*/)
        {
            Attack();
        }

        if (PlayerHealth.m_CurrentHealth <= 0)
        {

        }

        if (Easy)
        {
            attackDamage = 10;
        }

        if (Medium)
        {
            attackDamage = 34;

        }

        if (Hard)
        {
            attackDamage = 100;
        }
    }


    void Attack()
    {
        timer = 0f;

        if (PlayerHealth.m_CurrentHealth > 0)
        {
            playerHealth.TakeDamage(attackDamage);
        }
    }
}

