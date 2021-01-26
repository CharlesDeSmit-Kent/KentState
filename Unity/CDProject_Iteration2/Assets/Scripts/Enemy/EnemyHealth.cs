using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyHealth : MonoBehaviour {
    public int startingHealth = 100;
    public int currentHealth;
    public float sinkSpeed = 2.5f;

    BoxCollider boxCollider;
    bool isDead;
    bool isSinking;

    void Awake()
    {

        boxCollider = GetComponent<BoxCollider>();
        currentHealth = startingHealth;

    }


    void Update()
    {
        if (isSinking)
        {
            transform.Translate(-Vector3.up * sinkSpeed * Time.deltaTime);
        }
    }


    public void TakeDamage()
    {
        if (isDead)
            return;
        if (currentHealth <= 0)       
            Death();
        
    }


    void Death()
    {
        isDead = true;
        boxCollider.isTrigger = true;
    }


    public void StartSinking()
    {
        GetComponent<UnityEngine.AI.NavMeshAgent>().enabled = false;
        GetComponent<Rigidbody>().isKinematic = true;
        isSinking = true;
        Destroy(gameObject, 2f);
    }
}
