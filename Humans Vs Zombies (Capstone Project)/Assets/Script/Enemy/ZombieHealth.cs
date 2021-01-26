using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ZombieHealth : MonoBehaviour
{
    public int startingHealth = 100;            // The amount of health the enemy starts the game with.
    public int currentHealth;                   // The current health the enemy has.
    public float sinkSpeed = 2.5f;              // The speed at which the enemy sinks through the floor when dead.


    CapsuleCollider capsuleCollider;            // Reference to the capsule collider.
    bool isDead;                                // Whether the enemy is dead.
    bool isSinking;                             // Whether the enemy has started sinking through the floor.

    Animator anim;

    int amount = bullet.Damage;

    void Awake()
    {
        anim = GetComponent<Animator>();
        // Setting up the references.
        capsuleCollider = GetComponent<CapsuleCollider>();
        // Setting the current health when the enemy first spawns.
        currentHealth = startingHealth;
    }


    void Update()
    {
        // If the enemy should be sinking...
        if (isSinking)
        {
            // ... move the enemy down by the sinkSpeed per second.
            transform.Translate(-Vector3.up * sinkSpeed * Time.deltaTime);
        }
    }


    public void TakeDamage()
    {

        amount = bullet.Damage;
        // If the enemy is dead...
        if (isDead)
            // ... no need to take damage so exit the function.
            return;

        // Reduce the current health by the amount of damage sustained.
        currentHealth -= amount;

        // If the current health is less than or equal to zero...
        if (currentHealth <= 0)
        {
            // ... the enemy is dead.
            Death();
        }
    }


    void Death()
    {

        anim.SetTrigger("Dead");
        // The enemy is dead.
        isDead = true;
        ZombieAttack.attackDamage = 0;

        // Turn the collider into a trigger so shots can pass through it.
        capsuleCollider.isTrigger = true;

        StartSinking();

        ScoreManager.score += 10;

    }


    public void StartSinking()
    {
        // Find and disable the Nav Mesh Agent.
        GetComponent<UnityEngine.AI.NavMeshAgent>().enabled = false;

        // Find the rigidbody component and make it kinematic (since we use Translate to sink the enemy).
        GetComponent<Rigidbody>().isKinematic = true;

        // The enemy should no sink.
        isSinking = true;

        // After 2 seconds destory the enemy.
        Destroy(gameObject, 2f);
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.tag == "Bullet")
        {
                TakeDamage();
           
  
        }

        if (other.gameObject.tag == "Player")
        {
            anim.SetTrigger("Attacking");
        }
        else if (other.gameObject.tag != "Player")
        {
            anim.SetTrigger("Chasing");
        }
    }
}

