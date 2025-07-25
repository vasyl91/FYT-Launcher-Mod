/*
 * Copyright (C) 2010 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.android.gallery3d.glrenderer;


// Texture is a rectangular image which can be drawn on GLCanvas.
// The isOpaque() function gives a hint about whether the texture is opaque,
// so the drawing can be done faster.
//
// This is the current texture hierarchy:
//
// Texture
// -- ColorTexture
// -- FadeInTexture
// -- BasicTexture
// -- UploadedTexture
// -- BitmapTexture
// -- Tile
// -- ResourceTexture
// -- NinePatchTexture
// -- CanvasTexture
// -- StringTexture
//
public interface Texture {
    int getWidth();

    int getHeight();

    void draw(GLCanvas canvas, int x, int y);

    void draw(GLCanvas canvas, int x, int y, int w, int h);

    boolean isOpaque();
}
