using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class MenuControls : MonoBehaviour
{
    public GameObject MainMenu;
    public GameObject EscMenu;
    public GameObject PlayerHud;
    public GameObject DifficultyMenu;
    public GameObject Player;
    public GameObject Mouse;
    public GameObject Marker;
    public GameObject Weapon;
    public bool EscapeMenuOpen;
    public static float SpawnRate;  //out of 100
    public int ZombieDamage;//out of 100
    public int DartDamage;  //out of 100
    public GameObject Spawns;
    public GameObject Manager;
    public GameObject Score;

    // Start is called before the first frame update
    void Start()
    {
        Time.timeScale = 0;
        EscapeMenuOpen = false;
        Cursor.lockState = CursorLockMode.None;
        (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = false;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = false;
        MainMenu.SetActive(true);
        Spawns.SetActive(false);
        Manager.SetActive(false);
    }

    private void Awake()
    {
        Spawns.SetActive(false);
        Manager.SetActive(false);
    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            if (EscapeMenuOpen == false)
            {
                Time.timeScale = 0;
                EscapeMenuOpen = true;
                Cursor.lockState = CursorLockMode.None;
                (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = false;
                (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = false;
                EscMenu.SetActive(true);
            }
            else
            {
                Resume();
            }
        }
    }

    public void Play()
    {
        MainMenu.SetActive(false);
        DifficultyMenu.SetActive(true);
    }

    public void Exit()
    {
        Application.Quit(); //For actual Application
        //UnityEditor.EditorApplication.isPlaying = false; //For Editor
    }

    public void Resume()
    {
        Time.timeScale = 1;
        EscapeMenuOpen = false;
        Cursor.lockState = CursorLockMode.Locked;
        (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = true;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        EscMenu.SetActive(false);
    }

    public void Reset()
    {
        SceneManager.LoadScene(1);
    }

    public void Easy()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = true;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        PlayerHud.SetActive(true);
        Marker.SetActive(true);
        Spawns.SetActive(true);
        Manager.SetActive(true);
        SpawnRate = 10;
        ZombieAttack.Easy = true;
        bullet.Damage = 30;
        ScoreManager.multiplier = 1;
    }

    public void Medium()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = true;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        PlayerHud.SetActive(true);
        Marker.SetActive(true);
        Spawns.SetActive(true);
        Manager.SetActive(true);
        ZombieAttack.Medium = true;
        bullet.Damage = 10;
        ScoreManager.multiplier = 2;
    }

    public void Hard()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = true;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        PlayerHud.SetActive(true);
        Marker.SetActive(true);
        Spawns.SetActive(true);
        Manager.SetActive(true);
        ZombieAttack.Hard = true;
        bullet.Damage = 5;
        ScoreManager.multiplier = 5;
    }

    public void FreeRoam()
    {
        Time.timeScale = 1;
        Cursor.lockState = CursorLockMode.Locked;
        (Player.GetComponent("PlayerMovement") as MonoBehaviour).enabled = true;
        (Mouse.GetComponent("MouseView") as MonoBehaviour).enabled = true;
        DifficultyMenu.SetActive(false);
        PlayerHud.SetActive(false);
        Weapon.SetActive(false);
        Spawns.SetActive(false);
        Score.SetActive(false);
        Manager.SetActive(false);


    }
}
