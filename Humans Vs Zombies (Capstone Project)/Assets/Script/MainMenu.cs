using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{
    public GameObject Main_Menu;
    public GameObject DifficultyMenu;
    public GameObject Mouse;
    public static float SpawnRate;  //out of 100
    public int ZombieDamage;//out of 100
    public int DartDamage;  //out of 100

    // Start is called before the first frame update
    void Start()
    {
        Time.timeScale = 0;
       
        Cursor.lockState = CursorLockMode.None;
       
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = false;
        Main_Menu.SetActive(true);
    }

    
    public void Play()
    {
        Main_Menu.SetActive(false);
        DifficultyMenu.SetActive(true);
    }

    public void Exit()
    {
        Application.Quit(); //For actual Application
        //UnityEditor.EditorApplication.isPlaying = false; //For Editor
    }


    public void Easy()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        SpawnRate = 10;
        ZombieAttack.attackDamage = 10;
        bullet.Damage = 30;
    }

    public void Medium()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        SpawnRate = 5;
        ZombieAttack.attackDamage = 34;
        bullet.Damage = 10;
    }

    public void Hard()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        SpawnRate = 3;
        ZombieAttack.attackDamage = 100;
        bullet.Damage = 5;
    }
}
