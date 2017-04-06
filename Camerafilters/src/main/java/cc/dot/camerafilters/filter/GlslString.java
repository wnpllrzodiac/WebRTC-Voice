package cc.dot.camerafilters.filter;

/**
 * Created by xiang on 23/01/2017.
 */

public class GlslString {


    public  static  String   FragmentShaderBeautyString = "#extension GL_OES_EGL_image_external : require\n" +
            "\n" +
            "precision highp float;\n" +
            "\n" +
            "  uniform samplerExternalOES uTexture;\n" +
            "  uniform vec2 singleStepOffset;\n" +
            "\n" +
            "  const vec4 params = vec4(0.33, 0.63, 0.4, 0.35);\n" +
            "\n" +
            "  //const vec4 params = vec4(0.748, 0.874, 0.241, 0.241);\n" +
            "\n" +
            "  varying vec2 vTextureCoord;\n" +
            "\n" +
            "  const highp vec3 W = vec3(0.299,0.587,0.114);\n" +
            "\n" +
            "  const mat3 saturateMatrix = mat3(\n" +
            "        1.1102,-0.0598,-0.061,\n" +
            "        -0.0774,1.0826,-0.1186,\n" +
            "        -0.0228,-0.0228,1.1772);\n" +
            "\n" +
            "  vec2 blurCoordinates[24];\n" +
            "\n" +
            "  float hardLight(float color)\n" +
            "  {\n" +
            "    if(color <= 0.5)\n" +
            "    {\n" +
            "        color = color * color * 2.0;\n" +
            "    }\n" +
            "    else\n" +
            "    {\n" +
            "        color = 1.0 - ((1.0 - color)*(1.0 - color) * 2.0);\n" +
            "    }\n" +
            "    return color;\n" +
            "  }\n" +
            "\n" +
            "  void main(){\n" +
            "      vec3 centralColor = texture2D(uTexture, vTextureCoord).rgb;\n" +
            "\n" +
            "    blurCoordinates[0] = vTextureCoord.xy + singleStepOffset * vec2(0.0, -10.0);\n" +
            "    blurCoordinates[1] = vTextureCoord.xy + singleStepOffset * vec2(0.0, 10.0);\n" +
            "    blurCoordinates[2] = vTextureCoord.xy + singleStepOffset * vec2(-10.0, 0.0);\n" +
            "    blurCoordinates[3] = vTextureCoord.xy + singleStepOffset * vec2(10.0, 0.0);\n" +
            "    blurCoordinates[4] = vTextureCoord.xy + singleStepOffset * vec2(5.0, -8.0);\n" +
            "    blurCoordinates[5] = vTextureCoord.xy + singleStepOffset * vec2(5.0, 8.0);\n" +
            "    blurCoordinates[6] = vTextureCoord.xy + singleStepOffset * vec2(-5.0, 8.0);\n" +
            "    blurCoordinates[7] = vTextureCoord.xy + singleStepOffset * vec2(-5.0, -8.0);\n" +
            "    blurCoordinates[8] = vTextureCoord.xy + singleStepOffset * vec2(8.0, -5.0);\n" +
            "    blurCoordinates[9] = vTextureCoord.xy + singleStepOffset * vec2(8.0, 5.0);\n" +
            "    blurCoordinates[10] = vTextureCoord.xy + singleStepOffset * vec2(-8.0, 5.0);\n" +
            "    blurCoordinates[11] = vTextureCoord.xy + singleStepOffset * vec2(-8.0, -5.0);\n" +
            "    blurCoordinates[12] = vTextureCoord.xy + singleStepOffset * vec2(0.0, -6.0);\n" +
            "    blurCoordinates[13] = vTextureCoord.xy + singleStepOffset * vec2(0.0, 6.0);\n" +
            "    blurCoordinates[14] = vTextureCoord.xy + singleStepOffset * vec2(6.0, 0.0);\n" +
            "    blurCoordinates[15] = vTextureCoord.xy + singleStepOffset * vec2(-6.0, 0.0);\n" +
            "    blurCoordinates[16] = vTextureCoord.xy + singleStepOffset * vec2(-4.0, -4.0);\n" +
            "    blurCoordinates[17] = vTextureCoord.xy + singleStepOffset * vec2(-4.0, 4.0);\n" +
            "    blurCoordinates[18] = vTextureCoord.xy + singleStepOffset * vec2(4.0, -4.0);\n" +
            "    blurCoordinates[19] = vTextureCoord.xy + singleStepOffset * vec2(4.0, 4.0);\n" +
            "    blurCoordinates[20] = vTextureCoord.xy + singleStepOffset * vec2(-2.0, -2.0);\n" +
            "    blurCoordinates[21] = vTextureCoord.xy + singleStepOffset * vec2(-2.0, 2.0);\n" +
            "    blurCoordinates[22] = vTextureCoord.xy + singleStepOffset * vec2(2.0, -2.0);\n" +
            "    blurCoordinates[23] = vTextureCoord.xy + singleStepOffset * vec2(2.0, 2.0);\n" +
            "\n" +
            "    float sampleColor = centralColor.g * 22.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[0]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[1]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[2]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[3]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[4]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[5]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[6]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[7]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[8]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[9]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[10]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[11]).g;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[12]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[13]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[14]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[15]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[16]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[17]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[18]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[19]).g * 2.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[20]).g * 3.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[21]).g * 3.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[22]).g * 3.0;\n" +
            "    sampleColor += texture2D(uTexture, blurCoordinates[23]).g * 3.0;\n" +
            "    sampleColor = sampleColor / 62.0;\n" +
            "\n" +
            "    float highPass = centralColor.g - sampleColor + 0.5;\n" +
            "\n" +
            "    for(int i = 0; i < 5;i++)\n" +
            "    {\n" +
            "        highPass = hardLight(highPass);\n" +
            "    }\n" +
            "    float luminance = dot(centralColor, W);\n" +
            "    float alpha = pow(luminance, params.r);\n" +
            "\n" +
            "    vec3 smoothColor = centralColor + (centralColor-vec3(highPass))*alpha*0.1;\n" +
            "\n" +
            "    smoothColor.r = clamp(pow(smoothColor.r, params.g),0.0,1.0);\n" +
            "    smoothColor.g = clamp(pow(smoothColor.g, params.g),0.0,1.0);\n" +
            "    smoothColor.b = clamp(pow(smoothColor.b, params.g),0.0,1.0);\n" +
            "\n" +
            "    vec3 screen = vec3(1.0) - (vec3(1.0)-smoothColor) * (vec3(1.0)-centralColor);\n" +
            "    vec3 lighten = max(smoothColor, centralColor);\n" +
            "    vec3 softLight = 2.0 * centralColor*smoothColor + centralColor*centralColor\n" +
            "                    - 2.0 * centralColor*centralColor * smoothColor;\n" +
            "\n" +
            "    gl_FragColor = vec4(mix(centralColor, screen, alpha), 1.0);\n" +
            "    gl_FragColor.rgb = mix(gl_FragColor.rgb, lighten, alpha);\n" +
            "    gl_FragColor.rgb = mix(gl_FragColor.rgb, softLight, params.b);\n" +
            "\n" +
            "    vec3 satColor = gl_FragColor.rgb * saturateMatrix;\n" +
            "    gl_FragColor.rgb = mix(gl_FragColor.rgb, satColor, params.a);\n" +
            "\n" +
            "  }\n" +
            "\n";


    public  static  String   FragmentShaderNoFilterString = "#extension GL_OES_EGL_image_external : require\n" +
            "\n" +
            "precision mediump float;\n" +
            "\n" +
            "varying vec2 vTextureCoord;\n" +
            "uniform samplerExternalOES uTexture;\n" +
            "\n" +
            "void main() {\n" +
            "    gl_FragColor = texture2D(uTexture, vTextureCoord);\n" +
            "}";


    public static String  VertexShaderString = "uniform mat4 uMVPMatrix;  \n" +  // 整体变形
            "uniform mat4 uTexMatrix;  \n" +  // 只texture 变形
            "\n" +
            "attribute vec4 aPosition;\n" +
            "attribute vec4 aTextureCoord;\n" +
            "\n" +
            "varying vec2 vTextureCoord;\n" +
            "\n" +
            "void main() {\n" +
            "    gl_Position = uMVPMatrix * aPosition;\n" +
            "    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n" +
            "}";
}
