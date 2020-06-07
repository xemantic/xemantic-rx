/*
 * xemantic-rx - extensions to reactive extensions, RxJava and RxKotlin
 * Copyright (C) 2020  Kazimierz Pogoda
 *
 * This file is part of xemantic-rx.
 *
 *  xemantic-rx  is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 * xemantic-rx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with xemantic-rx.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package com.xemantic.rx;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.ThreadFactory;
import org.junit.jupiter.api.Test;

public class XemanticRxJavaTest {

  @Test
  public void shouldCreateThreadInstance() {
    // given
    ThreadFactory factory = XemanticRxKt.singleThreadFactory("foo");

    // when
    Thread thread = factory.newThread(() -> { /* do nothing */ });

    // then
    assertNotNull(thread);
  }

}
