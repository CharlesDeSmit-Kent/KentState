using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Checkpoint : MonoBehaviour
{
    public float radius = 1;
    public int lightNumber = 10;
    public Color color;
    public float spinSpeed = 1;
    public bool isGlowing = true;
    public int fronts = 1;
    public Material material;

    float radiusC;
    int lightNumberC;

    // Start is called before the first frame update
    void Start()
    {
        CreateRing();
        radiusC = radius;
        lightNumberC = lightNumber;
    }

    // Update is called once per frame
    void Update()
    {
        if(radius != radiusC || lightNumber != lightNumberC)
        {
            CreateRing();
        }

        int lightsPerFront = lightNumber / fronts;
        for (int j = 0; j < fronts; j++)
        {
            for(int i = 0; i < lightsPerFront; i++)
            {
                float percent = (float)i / (float)lightsPerFront;
                float newPercent = (percent + ((Time.time % spinSpeed) / spinSpeed)) % 1;
                transform.GetChild((lightsPerFront * j) + i).GetComponent<Renderer>().material.color = new Color(color.r, color.g, color.b, 1.0f - newPercent);
                if (isGlowing)
                {
                    transform.GetChild((lightsPerFront * j) + i).GetChild(0).GetComponent<Light>().intensity = 1.0f - newPercent;
                }
                else
                {
                    transform.GetChild((lightsPerFront * j) + i).GetChild(0).GetComponent<Light>().intensity = 0;
                }
            }
        }

        radiusC = radius;
        lightNumberC = lightNumber;
    }

    void CreateRing()
    {
        for(int i = 0; i < lightNumberC; i++)
        {
            Destroy(transform.GetChild(i).gameObject);
        }

        float circumfrence = Mathf.PI * radius * radius;
        for(int i = 0; i < lightNumber; i++)
        {
            GameObject sphere = GameObject.CreatePrimitive(PrimitiveType.Sphere);
            sphere.transform.parent = this.transform;
            float size = radius / lightNumber * 5;
            sphere.transform.localScale = new Vector3(size, size, size);
            sphere.GetComponent<Renderer>().material = material;
            sphere.GetComponent<Renderer>().material.SetInt("_SrcBlend", (int)UnityEngine.Rendering.BlendMode.One);
            sphere.GetComponent<Renderer>().material.SetInt("_DstBlend", (int)UnityEngine.Rendering.BlendMode.OneMinusSrcAlpha);
            sphere.GetComponent<Renderer>().material.SetInt("_ZWrite", 0);
            sphere.GetComponent<Renderer>().material.DisableKeyword("_ALPHATEST_ON");
            sphere.GetComponent<Renderer>().material.DisableKeyword("_ALPHABLEND_ON");
            sphere.GetComponent<Renderer>().material.EnableKeyword("_ALPHAPREMULTIPLY_ON");
            sphere.GetComponent<Renderer>().material.renderQueue = 3000;

            GameObject light = new GameObject("Ring Light");
            Light lightComp = light.AddComponent<Light>();
            lightComp.color = color;
            light.transform.parent = sphere.transform;

            float angle = i * Mathf.PI * 2 / lightNumber;
            Vector3 position = new Vector3(Mathf.Cos(angle) * radius, transform.position.y, Mathf.Sin(angle) * radius);
            sphere.transform.position = transform.position + position;
        }
    }
}
