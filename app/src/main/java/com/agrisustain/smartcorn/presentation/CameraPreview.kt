package com.agrisustain.smartcorn.presentation
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.agrisustain.smartcorn.R

@Composable
fun CameraPreview(contentPadding: PaddingValues = PaddingValues()) {

    // Obtain the current context and lifecycle owner
    val context = LocalContext.current
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current

    // Remember a LifecycleCameraController for this composable
    val cameraController = remember {
        LifecycleCameraController(context).apply {
            // Bind the LifecycleCameraController to the lifecycleOwner
            bindToLifecycle(lifecycleOwner)
        }
    }
    // Key Point: Displaying the Camera Preview
//    AndroidView(
//        modifier = Modifier.fillMaxSize(),
//        factory = { ctx ->
//            // Initialize the PreviewView and configure it
//            PreviewView(ctx).apply {
//                scaleType = PreviewView.ScaleType.FILL_START
//                implementationMode = PreviewView.ImplementationMode.COMPATIBLE
//                controller = cameraController // Set the controller to manage the camera lifecycle
//            } },
//        onRelease = {
//            // Release the camera controller when the composable is removed from the screen
//            cameraController.unbind()
//        }
//    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(contentPadding)
    ) {
        // Camera Preview
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                PreviewView(ctx).apply {
                    scaleType = PreviewView.ScaleType.FILL_START
                    implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                    controller = cameraController // Set the controller to manage the camera lifecycle
                }
            },
            onRelease = {
                // Release the camera controller when the composable is removed from the screen
                cameraController.unbind()
            }
        )

        // UI Elements
        IconButton(
            onClick = { /* Handle Flash toggle */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_flash_on_24),
                contentDescription = "Flash",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }

        IconButton(
            onClick = { /* Handle Camera Switch */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_cameraswitch_24),
                contentDescription = "Switch Camera",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }

        IconButton(
            onClick = { /* Handle Gallery Access */ },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_photo_camera_24),
                contentDescription = "Gallery",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .size(80.dp)
                .background(Color.White, shape = CircleShape)
        ) {
            // Centered Action Button (e.g., Capture Photo)
        }

        IconButton(
            onClick = { /* Handle Help Action */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_info_24),
                contentDescription = "Help",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCamera () {
    CameraPreview()
}
