using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PowerUpSpawner : MonoBehaviour {
	
    public PlayerHealth playerHealth;
    public GameObject pickUp;
    public float spawnTime;
    public Transform[] spawnPoints;
    int pickUpCount;

    void Start()
    {
        spawnTime = Random.Range(3.0f, 15.0f);
    }

    void Update()
    {
        pickUpCount = GameObject.FindGameObjectsWithTag("Pick Up").Length; 
        if (spawnTime <= 0 && pickUpCount == 0)
            Spawn();
        if (spawnTime > 0)
            spawnTime -= Time.deltaTime;
    }
    void Spawn()
    {
        if (playerHealth.currentHealth <= 0f)
        {
            return;
        }

        int spawnPointIndex = Random.Range(0, spawnPoints.Length);

        Instantiate(pickUp, spawnPoints[spawnPointIndex].position, spawnPoints[spawnPointIndex].rotation);
        spawnTime = Random.Range(3.0f, 15.0f);

    }
}
