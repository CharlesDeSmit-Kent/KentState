using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraMovement : MonoBehaviour {

    public Vector3 offset;
    public Transform player;
    public float sensitivity;
    public bool usingOffset;
    public Transform pivot;

    void Start()
    {
        if(!usingOffset) offset = player.position - transform.position;
        pivot.transform.position = player.transform.position;
        pivot.transform.parent = player.transform;
    }

    void LateUpdate()
    {
        float h = Input.GetAxis("Mouse X") * sensitivity;
        float v = Input.GetAxis("Mouse Y") * sensitivity;
        player.Rotate(0f, h, 0f);
        pivot.Rotate(-v, 0f, 0f);
        float yCorrect = player.eulerAngles.y;
        float xCorrect = pivot.eulerAngles.x;

        Quaternion rotation = Quaternion.Euler(xCorrect, yCorrect, 0);
        transform.position = player.position - (rotation * offset);
        if (transform.position.y < player.position.y) transform.position = new Vector3(transform.position.x, player.position.y - 0.4f, transform.position.z);
        transform.LookAt(player);
    }
}