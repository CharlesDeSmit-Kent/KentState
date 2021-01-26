using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[ExecuteInEditMode]
public class CopyMaterialColor : MonoBehaviour {

	private TextMesh _textMesh;
	private MeshRenderer _meshRenderer;
	private Material _material;
	private MaterialPropertyBlock _block;
	private Color _color;

	public void Update ()
	{
		if ( _textMesh == null )
		{
			_textMesh = GetComponent<TextMesh>();
		}

		if ( _meshRenderer == null )
		{
			_meshRenderer = GetComponent<MeshRenderer>();
		}

		if ( _block == null )
		{
			_block = new MaterialPropertyBlock();
			_color = _textMesh.color;
			_block.SetColor( "_Color", _color );
			_meshRenderer.SetPropertyBlock( _block );
		}
		else if ( _textMesh.color != _color )
		{
			_color = _textMesh.color;
			_block.SetColor( "_Color", _color );
			_meshRenderer.SetPropertyBlock( _block );
		}
	}
}
