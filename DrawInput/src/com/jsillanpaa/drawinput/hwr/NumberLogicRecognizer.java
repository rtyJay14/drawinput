package com.jsillanpaa.drawinput.hwr;

import android.util.Log;

import com.jsillanpaa.drawinput.char_recognizers.CharRecognitionResult;

public class NumberLogicRecognizer extends LogicRecognizer {
	
	private static final String TAG = "NumberLogicRecognizer";


	public NumberLogicRecognizer(int canvasWidth, int canvasHeight) {
		super(canvasWidth, canvasHeight);
	}

	@Override
	public CharRecognitionResult tryRecognition(HwrCharacter ch) {
		Log.i(TAG, "tryRecognition()");
		
		
		Log.i(TAG, "canvasWidth= " +mCanvasWidth);
		Log.i(TAG, "canvasHeight= " +mCanvasHeight);
		
		int num_strokes = ch.strokes.size();
		switch (num_strokes) {
			case 1: return tryOneStrokeRecognition(ch);
			default: return null;
		}
		
	}

	private CharRecognitionResult tryOneStrokeRecognition(HwrCharacter ch) {
		Log.i(TAG, "tryOneStrokeRecognition()");
		HwrStroke stroke = ch.strokes.get(0);
		
		if(isVerticalLine(stroke)){
			return new CharRecognitionResult('1');
		}
		
		return null;
	}



}