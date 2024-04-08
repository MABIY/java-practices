package onjava.atunit;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lh
 */
public class ClassNameFinder {
    public static String thisClass(byte[] classBytes) {
        Map<Integer,Integer> offsetTable = new HashMap<>();
        Map<Integer,String> classNameTable = new HashMap<>();
        try {
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));
            int magic = data.readInt();
            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            int constantPoolCount =data.readShort();
            int[] constantPool = new int[constantPoolCount];
            for (int i = 1; i <constantPoolCount; i++) {
                int tag =data.read();
                // int tableSize:
                switch (tag) {
                    case 1: //UTF
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for (int k = 0; k <bytes.length; k++) {
                            bytes[k] = (char) data.read();
                        }
                        String className = new String(bytes);
                        classNameTable.put(i,className);
                        break;
                    case 5: // LONG
                    case 6: // DOUBLE
                        data.readLong(); //discard 8 bytes
                        i++; // Special skip necessary
                        break;
                    case 7: // CLASS
                        int offset = data.readShort();
                        offsetTable.put(i,offset);
                        break;
                    case 8: // STRING
                        data.readShort(); // discard 2 bytes
                        break;
                    case 3: //INTEGER
                    case 4: // FLOAT
                    case 9:// FIELD_REF
                    case 10: //METHOD_REF
                    case 11: //INTERFACE_METHOD_REF
                    case 12: // NAME_AND_TYPE
                    case 18: // Invoke Dynamic
                        data.readInt(); // discard 4 bytes
                        break;
                    case 15:
                        data.readByte();
                        data.readShort();
                        break;
                    case 16: //Method Type
                        data.readShort();
                        break;
                    default:
                        throw new RuntimeException("Bad tag " + tag);

                }
            }
            short accessFlags = data.readShort();
            String access = (accessFlags & 0x0001) ==0 ? "nonpublic:":"public:";
            int thisClass = data.readShort();
            int superClass = data.readShort();
            return access + classNameTable.get(offsetTable.get(thisClass)).replace('/','.');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
