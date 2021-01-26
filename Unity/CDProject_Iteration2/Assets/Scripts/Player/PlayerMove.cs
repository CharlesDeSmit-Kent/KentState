using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour {

    public float speed = 6f;
    Vector3 movement;
    public float jumpHeight;
    public float playerGravity;
    public CharacterController control;
    public float hitInvulnerable;

    bool powerActive;
    float powerTimer;


    void Awake()
    {
        powerActive = false;
        powerTimer = 15.0f;
        control = GetComponent<CharacterController>();
    }


    void Update()
    {
        float h = Input.GetAxisRaw("Horizontal");
        float v = Input.GetAxisRaw("Vertical");
        Move(h, v);
        if (hitInvulnerable > 0.0f)
            hitInvulnerable -= Time.deltaTime;
        if (powerActive)
            powerTimer -= Time.deltaTime;
        if(powerTimer <= 0.0f)
        {
            powerActive = false;
            powerTimer = 15.0f;
        }
    }

    void Move(float h, float v)
    {
        float tempY = movement.y;
        movement = (transform.forward * v) + (transform.right * h);
        movement = movement.normalized * speed;
        movement.y = tempY;
        if (control.isGrounded)
        {
            movement.y = 0f;
            if (Input.GetButtonDown("Jump")) movement.y = jumpHeight;
        }
        movement.y = movement.y + (Physics.gravity.y * playerGravity * Time.deltaTime);
        control.Move(movement * Time.deltaTime);
    }
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Objective"))
        {
            other.gameObject.SetActive(false);
            GameObject.Find("GameManager").GetComponent<GameControl>().objectives += 1;
        }
        if (other.gameObject.CompareTag("Card"))
        {
            other.gameObject.SetActive(false);
            GameObject.Find("GameManager").GetComponent<GameControl>().score += 10;
            GameObject.Find("GameManager").GetComponent<GameControl>().cards += 1;
        }
        if (other.gameObject.CompareTag("PowerUp"))
        {
            other.gameObject.SetActive(false);
            powerActive = true;
        }
        if (other.gameObject.CompareTag("Enemy"))
        {
            if (powerActive)
            {
                other.gameObject.SetActive(false);
                GameObject.Find("GameManager").GetComponent<GameControl>().enemies += 1;
            }
            else if (!powerActive && hitInvulnerable <= 0.0f)
            {
                GetComponent<PlayerHealth>().currentHealth -= 10;
                hitInvulnerable = 0.5f;
            }
        }

    }
}