using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameControl : MonoBehaviour {

    public int score;
    public int objectives;
    public int cards;
    public int enemies;
    int health;


    public Transform cardObjective;
    public GameObject player;

    private bool objective2Spawned;
    private bool objective3Spawned;


    // Use this for initialization
    void Start () {
        objective2Spawned = false;
        objective3Spawned = false;
    }

    // Update is called once per frame
    void Update () {
        CheckCards();
        CheckEnemies();
        GameOver();
        if (Input.GetKey("escape"))
            Application.Quit();
    }

    void CheckCards()
    {
        if (cards == 20 && objective2Spawned == false)
        {
            spawnObjective();
            objective2Spawned = true;
        }
    }
    void CheckEnemies()
    {
        if(enemies == 2 && objective3Spawned == false)
        {
            spawnObjective();
            objective3Spawned = true;
        }
    }
    void GameOver()
    {
        health = GameObject.Find("PlayerCube").GetComponent<PlayerHealth>().currentHealth;
        
        float height = player.transform.position.y;
        if (height < -1.0f || health == 0 || objectives == 3)
        {
            SceneManager.LoadScene(0);
            //SceneManager.LoadSceneAsync(SceneManager.GetActiveScene().buildIndex);
        }

    }
    void spawnObjective()
    {
        Vector3 spawnPosition = player.transform.position;
        spawnPosition.y += 2.5f;
        Instantiate(cardObjective, spawnPosition, Quaternion.identity);
    }
       

}
