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

package com.xemantic.rx

import ch.tutteli.atrium.api.fluent.en_GB.isA
import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import io.reactivex.rxjava3.internal.schedulers.NonBlockingThread
import org.junit.jupiter.api.Test

class XemanticRxTest {

  @Test
  fun `should create Thread instance`() {
    // given
    val factory = singleThreadFactory("foo")

    // when
    val thread = factory.newThread { /* doing nothing */ }

    // then
    expect(thread).isA<NonBlockingThread>()
    expect(thread.name).toBe("foo")
    expect(thread.isDaemon).toBe(true)
  }

}
