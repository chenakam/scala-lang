/*
 * Copyright (C) 2017-present, Chenai Nakam(chenai.nakam@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hobby.chenai.nakam.tool.pool

/**
  * @author Chenai Nakam(chenai.nakam@gmail.com)
  * @version 1.0, 05/01/2018;
  *          1.1, 14/08/2018, 新增`_2S`以便集成。
  */
class S extends Cap[String] {
  override def equals(o: Any) = o match {
    case that: S => that.canEqual(this) && that.get == this.get
    case _ => false
  }

  override def canEqual(that: Any) = that.isInstanceOf[S]

  override def hashCode = get.fold(0)(_.hashCode)
}

trait _2S extends Pool[String, S] {
  implicit class _2S(_s: String) {
    @inline def s: S = obtain(_s)
  }

  def s(_s: String): S = _s.s

  protected override def newCap = new S
}

object S extends _2S
