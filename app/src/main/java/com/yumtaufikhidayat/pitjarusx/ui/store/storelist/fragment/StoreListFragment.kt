package com.yumtaufikhidayat.pitjarusx.ui.store.storelist.fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yumtaufikhidayat.pitjarusx.R
import com.yumtaufikhidayat.pitjarusx.databinding.FragmentStoreListBinding
import com.yumtaufikhidayat.pitjarusx.model.login.Store
import com.yumtaufikhidayat.pitjarusx.ui.store.storelist.adapter.StoreListAdapter
import com.yumtaufikhidayat.pitjarusx.ui.store.storelist.viewmodel.StoreListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StoreListFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentStoreListBinding? = null
    private val binding get() = _binding!!

    private var mMap: GoogleMap? = null
    private val viewModel: StoreListViewModel by viewModels()
    private val storeListAdapter by lazy { StoreListAdapter(::navigateToDetailStore) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStoreListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleBackNavigation()
        setMap()
        setStoreListAdapter()
    }

    private fun handleBackNavigation() {
        binding.imgBackArrow.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setStoreListAdapter() {
        binding.rvStoreList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = storeListAdapter
        }
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isIndoorLevelPickerEnabled = true
            isCompassEnabled = false
            isMapToolbarEnabled = true
            isScrollGesturesEnabledDuringRotateOrZoom = false
            isRotateGesturesEnabled = false
        }

        setObserver()
    }

    private fun setObserver() {
        viewModel.getLogin().observe(viewLifecycleOwner) {
            setMarkers(it)
            showStoreList(it)
        }
    }

    private fun setMarkers(storeList: List<Store>) {
        binding.apply {
            val username = storeList[0].accountName
            tvToolbarSubtitle.text = username
            storeList.forEach {
                val latitude = it.latitude.toDouble()
                val longitude = it.longitude.toDouble()
                val latLng = LatLng(latitude, longitude)

                mMap?.let { gMap ->
                    gMap.addMarker(
                        MarkerOptions()
                            .position(latLng)
                            .title(it.storeName)
                            .icon(
                                vectorToBitmap(
                                    R.drawable.baseline_place,
                                    Color.parseColor("#00FF00")
                                )
                            )
                    )
                    gMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            latLng,
                            ZOOM_LEVEL
                        )
                    )
                }
            }
        }
    }

    private fun showStoreList(storeList: List<Store>) {
        storeListAdapter.submitList(storeList)
    }

    private fun navigateToDetailStore() {
        findNavController().navigate(R.id.storeDetailFragment)
    }

    private fun vectorToBitmap(@DrawableRes id: Int, @ColorInt color: Int): BitmapDescriptor {
        val vectorDrawable = ResourcesCompat.getDrawable(resources, id, null)
        if (vectorDrawable == null) {
            Log.e("BitmapHelper", "Resource not found")
            return BitmapDescriptorFactory.defaultMarker()
        }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        DrawableCompat.setTint(vectorDrawable, color)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ZOOM_LEVEL = 15f
    }
}