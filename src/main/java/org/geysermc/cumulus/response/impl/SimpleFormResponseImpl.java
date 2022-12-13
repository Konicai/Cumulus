/*
 * Copyright (c) 2020-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Cumulus
 */

package org.geysermc.cumulus.response.impl;

import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.cumulus.component.ButtonComponent;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.cumulus.response.result.ResultType;
import org.geysermc.cumulus.util.Preconditions;

public final class SimpleFormResponseImpl extends ResponseToResultGlue
    implements SimpleFormResponse {

  private final int clickedButtonId;
  private final ButtonComponent clickedButton;

  private SimpleFormResponseImpl(int clickedButtonId, ButtonComponent clickedButton) {
    Preconditions.checkArgument(clickedButtonId >= 0, "clickedButtonId");
    this.clickedButtonId = clickedButtonId;
    this.clickedButton = Objects.requireNonNull(clickedButton, "clickedButton");
  }

  @Deprecated
  public SimpleFormResponseImpl(ResultType resultType) {
    //todo remove in 2.0
    super(resultType);
    clickedButtonId = -1;
    clickedButton = null;
  }

  public static SimpleFormResponseImpl of(int clickedButtonId, ButtonComponent clickedButton) {
    return new SimpleFormResponseImpl(clickedButtonId, clickedButton);
  }

  @Override
  public int clickedButtonId() {
    return clickedButtonId;
  }

  @Override
  @NonNull
  public ButtonComponent clickedButton() {
    return clickedButton;
  }

  // the JVM doesn't allow interface methods to become default methods

  public int getClickedButtonId() {
    return clickedButtonId();
  }

  public ButtonComponent getClickedButton() {
    return clickedButton();
  }
}
