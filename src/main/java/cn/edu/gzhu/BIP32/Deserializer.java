/*
 *  BIP32 library, a Java implementation of BIP32
 *  Copyright (C) 2017-2019 Alan Evans, NovaCrypto
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *  Original source: https://github.com/NovaCrypto/BIP32
 *  You can contact the authors via github issues.
 */

package cn.edu.gzhu.BIP32;

public interface Deserializer<T> {

    /**
     * Deserializes the data into a {@link T}.
     *
     * @param extendedBase58Key Base58 CharSequence containing the serialized extended key.
     * @return The {@link T}
     */
    T deserialize(CharSequence extendedBase58Key);

    /**
     * Deserializes the data into a {@link T}.
     *
     * @param extendedKeyData Byte array containing the serialized extended key.
     * @return The {@link T}
     */
    T deserialize(byte[] extendedKeyData);
}