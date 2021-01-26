using UnityEngine;
using System.Collections;

public class EnemyMovement : MonoBehaviour
{
    Transform player;
    bool reverse;
    PlayerHealth playerHealth;
    EnemyHealth enemyHealth;
    UnityEngine.AI.NavMeshAgent nav;

    GameObject powerUpController;
    PowerUpActive PowerUp;
    void Awake ()
    {
        player = GameObject.FindGameObjectWithTag ("Player").transform;
        playerHealth = player.GetComponent <PlayerHealth> ();
        enemyHealth = GetComponent <EnemyHealth> ();
        nav = GetComponent <UnityEngine.AI.NavMeshAgent> ();
        reverse = false;

        powerUpController = GameObject.FindGameObjectWithTag("GameController");
        PowerUp = powerUpController.GetComponent<PowerUpActive>();
    }


    void Update ()
    {
        if (enemyHealth.currentHealth > 0 && playerHealth.currentHealth > 0)
        {
            /*if (Input.GetKeyDown("space")){
                reverse = !reverse;
            }
            if (reverse) {
                //nav.SetDestination(-(player.position));
                Vector3 targetDestination = player.transform.TransformDirection(transform.right) + new Vector3(Random.Range(5, 5), 0, Random.Range(5, 5));
                nav.SetDestination(targetDestination);

            }
            else
            {*/
            if (PowerUp.powerUpActive)
            {
                Vector3 runDestination = new Vector3(0, 0, 0);
                nav.SetDestination(runDestination);
            }
                nav.SetDestination(player.position);
            //}
        }
        else
        {
            nav.enabled = false;
        }
    }
}
